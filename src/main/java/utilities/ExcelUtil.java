package utilities;

public class ExcelUtil {
//	private File spreadsheet;
//	private Sheet currentSheet;
//	private Map<String, Integer> columns;
//
//	public SpreadsheetUtil(File file){
//	        spreadsheet = file;
//	        columns = new HashMap();
//	    }
//
//	public void switchToSheet(String name) {
//		try (var workbooks = WorkbookFactory.create(spreadsheet)) {
//			currentSheet = workbooks.getSheet(name);
//			currentSheet.getRow(0).forEach(cell -> {
//				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public String getCellData(String column, int row) {
//		var dataRow = currentSheet.getRow(row);
//		return getCellDataAsString(dataRow.getCell(columns.get(column)));
//	}
//
//	private String getCellDataAsString(Cell cell) {
//		return switch (cell.getCellType()) {
//		case STRING -> cell.getStringCellValue();
//		case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
//		default -> "";
//		};
//	}
}

