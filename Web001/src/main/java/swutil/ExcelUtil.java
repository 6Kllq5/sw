package swutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtil {
	
	//上传excel目录
		public static String uploadUserExcelFile(MultipartFile file,HttpServletRequest request){
			String  resultString =null;
			String reallyName= file.getOriginalFilename();// 获取问价名称是传过来的文件名称
			String array[]=reallyName.split("\\.");
			String suff=array[array.length-1];
			try{
				String filename=String.valueOf(new Date().getTime())+"."+suff;//使用时间作为文件名称保证唯一
//				
				String webroot = request.getServletContext().getRealPath("/");
				String userFolder=request.getParameter("fk_userid");//对应上传者的目录
				//upload目录
				File upload=new File(webroot.trim(),"file");
				//用户目录
				File user_upload_path=new File(upload,userFolder.trim());
				//案例目录
				//判断目录是否存在不存在则创建
				if(!upload.exists()){
					upload.mkdirs();
				}
				if(!user_upload_path.exists()){
					user_upload_path.mkdirs();
				}
				
				File newFile = new File(user_upload_path, filename);
				if (newFile.exists()) {
					newFile.delete();
				}
				//移动目录
				file.transferTo(newFile);
				//拼接路径
				resultString=user_upload_path.getPath()+"\\"+filename;
			}catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultString;
		}
	
	
	//处理excel 文件数据导入数据库--返回list--里面包含所有的记录
		public static List dealExcel(MultipartFile file,HttpServletRequest request){
			List resultList=new ArrayList();
			String filepath=uploadUserExcelFile(file,request);
			//使用poi库处理excel表格数据
			FileInputStream fis;
			try {
				fis = new FileInputStream(filepath);
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				HSSFSheet sheet = wb.getSheetAt(0); 					//sheet 从0开始
				//取得该sheet的行数
				int rowNum = sheet.getLastRowNum() + 1;
				int cellNum=sheet.getRow(0).getLastCellNum();//根据表头来确定的列数
				for (int i = 0; i < rowNum; i++) {
					if(i==0){
						//表头
						continue;
					}
					Map pd=new HashMap();//每一次遍历行的时候创建一个新的pd map对象用于存放记录
					
					String userid=UUIDUtil.getRandom().toString();//为每一条记录生成一个userid
					pd.put("userid", userid);//存放
					//获取当前行
					HSSFRow row = sheet.getRow(i);
					//获取该行的列数
					//遍历单元格
					for (int j = 0; j < cellNum; j++) {	
						//获取单元格
						HSSFCell cell = row.getCell(j);
						//判断值的类型
						if(i>=1&&j==0){//从第二行开始遍历并且开始赋值
							pd.put("loginname", parseString(cell));
							System.out.println(parseString(cell));
							continue;
						}
						
						if(i>=1&&j==1){//从第二行开始遍历并且开始赋值
							pd.put("password", parseString(cell));
							System.out.println(parseString(cell));
							continue;
						}
						
						if(i>=1&&j==2){//从第二行开始遍历并且开始赋值
							pd.put("role", parseString(cell));
							System.out.println(parseString(cell));
							continue;
						}
						
						if(i>=1&&j==3){//从第二行开始遍历并且开始赋值
							System.out.println(parseString(cell));
							pd.put("bianhao", parseString(cell));
							continue;
						}
						
						if(i>=1&&j==4){//从第二行开始遍历并且开始赋值
							System.out.println(parseString(cell));
							pd.put("xueyuan", parseString(cell));
							continue;
						}
						
						if(i>=1&&j==5){//从第二行开始遍历并且开始赋值
							System.out.println(parseString(cell));
							pd.put("xi", parseString(cell));
							continue;
						}
						
						if(i>=1&&j==6){//从第二行开始遍历并且开始赋值
							System.out.println(parseString(cell));
							pd.put("banji",parseString(cell));
							continue;
						}
					}
					//存放
					resultList.add(pd);
				}
				wb.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultList;
	}
	public static String parseString(HSSFCell cell){
		String returnStr=null;
		DecimalFormat df = new DecimalFormat("0");  
		if(cell==null){
			return "";
		}
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				returnStr= cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				returnStr= String.valueOf(df.format(cell.getNumericCellValue()));
				break;
		}
		return returnStr;
	}
}
