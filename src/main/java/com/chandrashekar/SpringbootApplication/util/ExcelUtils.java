package com.chandrashekar.SpringbootApplication.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.chandrashekar.SpringbootApplication.model.InstallationDetails;

public class ExcelUtils {

	public static String SHEET = "SERVICE_ResolvedInstallationActivationDetail";
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public static List<InstallationDetails> excelToTutorials(InputStream is) {
		List<InstallationDetails> installDetailsList = new ArrayList<InstallationDetails>();
		try {
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0 || rowNumber == 1) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();
				InstallationDetails installDetails = new InstallationDetails();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					installDetails.setId(ThreadLocalRandom.current().nextLong());
					if (cellIdx == 0) {
						installDetails.setProductType(currentCell.getStringCellValue());
					}
					if (cellIdx == 1) {
						installDetails.setTerritory(currentCell.getStringCellValue());
					}
					if (cellIdx == 2) {
						installDetails.setDivision(currentCell.getStringCellValue());
					}
					if (cellIdx == 3) {
						installDetails.setDsm(currentCell.getStringCellValue());
					}
					if (cellIdx == 4) {
						installDetails.setZoneName(currentCell.getStringCellValue());
					}
					if (cellIdx == 5) {
						installDetails.setCsm(currentCell.getStringCellValue());
					}
					if (cellIdx == 6) {
						installDetails.setCsm(currentCell.getStringCellValue());
					}
					if (cellIdx == 7) {
						installDetails.setDcc(currentCell.getStringCellValue());
					}
					if (cellIdx == 8) {
						installDetails.setDccId(currentCell.getStringCellValue());
					}
					if (cellIdx == 9) {
						installDetails.setDccType(currentCell.getStringCellValue());
					}
					cellIdx++;
					installDetailsList.add(installDetails);
				}
			}
			workbook.close();

		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
		return installDetailsList;
	}

	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

}
