package com.hisign.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;

import com.hisign.model.SysDict;
import com.hisign.util.UUIDService;

/**
 * 字典代码脚本生成器
 * 
 * @author Hong
 */
public class SysDictGenerator {

	private static final String OUTPUT_FILE_PATH = "./output/sql/";

	private static final String INPUT_FILE_PATH = "./input/XCKY_SYS_DICT_TEMPLATE.xls";

	private static final String SUFFIX = ".sql";

	private static final String ROOT_PARENT_KEY = "SYS_DICT";

	/**
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public static void generate() throws Exception {

		System.out.println("==========字典代码脚本生成器==========");
		System.out.println("请将字典代码模板文件放入input文件夹，按回车继续!");

		new Scanner(System.in).nextLine();

		Map context = new HashMap();
		List<SysDict> sysDictList = new ArrayList<SysDict>();
		context.put("sysDictList", sysDictList);

		File file = new File(INPUT_FILE_PATH);

		if (!file.exists()) {
			System.out.println("input目录下不存在数据文件(XCKY_SYS_DICT_TEMPLATE.xls)");
			System.exit(0);
		}

		InputStream in = new FileInputStream(file);
		Workbook workBook = Workbook.getWorkbook(in);
		Sheet[] sheets = workBook.getSheets();

		if (sheets == null || sheets.length == 0) {
			return;
		}

		for (Sheet sheet : sheets) {
			int rows = sheet.getRows();// 记录数量

			String dictKey, parentKey, dictValue;
			int dictSort = 0;
			SysDict rootDict = null;// 根节点
			String rootKey = null;
			List<String> dictKeyList = new ArrayList<String>();

			for (int j = 1; j < rows; j++) {
				Cell cell = sheet.getCell(0, j);
				dictKey = cell.getContents().trim();
				dictKeyList.add(dictKey);

				cell = sheet.getCell(1, j);
				parentKey = cell.getContents().trim();

				cell = sheet.getCell(2, j);
				dictValue = cell.getContents().trim();

				System.out.println(dictKey + "--" + parentKey + "--" + dictValue);

				if (StringUtils.isBlank(dictKey) || StringUtils.isBlank(dictValue)) {
					System.out.println("字典代码或中文名称不允许为空！");
					System.exit(0);
				}

				if (j == 1) {
					// 根节点
					rootKey = dictKey;
					parentKey = ROOT_PARENT_KEY;
					rootDict = new SysDict();
					rootDict.setId(UUIDService.getInstance().simpleHex());
					rootDict.setRootKey(rootKey);
					rootDict.setDictValue(dictValue);
					rootDict.setDictSort(dictSort++);
					sysDictList.add(rootDict);
				} else if (!dictKeyList.contains(parentKey)) {
					System.out.println("父级字典代码有误！");
					System.exit(0);
				}

				SysDict sysDict = new SysDict();
				sysDict.setId(UUIDService.getInstance().simpleHex());
				sysDict.setRootKey(rootKey);
				sysDict.setDictKey(dictKey);
				sysDict.setParentKey(parentKey);
				sysDict.setDictValue(dictValue);
				sysDict.setDictSort(dictSort++);
				sysDict.setShowFlag("0");
				sysDict.setAllowModify("0");
				sysDict.setOpenFlag("1");
				sysDict.setVersion(String.valueOf(System.currentTimeMillis()));
				sysDict.setDeleteFlag("0");
				rootDict.getSysDictList().add(sysDict);
			}
		}

		in.close();
		workBook.close();

		String outputFilePath = OUTPUT_FILE_PATH + "sys_dict" + SUFFIX;
		try {
			FreeMarkerManager.getInstance().renderTemplate("SysDictSqlTemplate.sql", outputFilePath, context, "UTF-8");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		System.out.println("==========完成==========");
	}

	public static void main(String[] args) throws Exception {
		SysDictGenerator.generate();
	}

}
