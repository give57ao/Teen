package com.ez.teen.common.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.CommentModel;
import com.ez.teen.notice.model.NoticeModel;

@Component("fileUtils")
public class FileUtil {
	
	private static final String filePath = "C:\\upload\\";
	public String getFilePath() {
		return filePath;
	}
	
	public List<Map<String, Object>> parseInsertFileInfo(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception{
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multpartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> listMap = null;
		
		int board_no = boardModel.getBoard_no();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		} 
		
		while (iterator.hasNext()) {
			multpartFile = mpRequest.getFile(iterator.next());
			
			if(multpartFile.isEmpty() == false) {
				originalFileName = multpartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				
				storedFileName = getRandomString() + originalFileExtension;
				Date date = new Date();
				
				file = new File(filePath + storedFileName);
				multpartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("NEW_FILE", "Y");
				listMap.put("BOARD_NO", board_no);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multpartFile.getSize());
				listMap.put("FILE_DATE", date);
				list.add(listMap);
			}
		}
		return list;
	}
	
	public List<Map<String, Object>> parseInsertnoticeFileInfo(NoticeModel noticeModel,MultipartHttpServletRequest mpRequest) throws Exception{
		
			Iterator<String> iterator = mpRequest.getFileNames();
		
			MultipartFile multpartFile = null;
			String originalFileName = null;
			String originalFileExtension = null;
			String storedFileName = null;
		
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
			Map<String, Object> listMap = null;
		
			int noti_no = noticeModel.getNoti_no();
				
			File file = new File(filePath);
			if(file.exists() == false) {
				file.mkdirs();
			} 
		
			while (iterator.hasNext()) {
				multpartFile = mpRequest.getFile(iterator.next());
			
				if(multpartFile.isEmpty() == false) {
					originalFileName = multpartFile.getOriginalFilename();
					originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				
					storedFileName = getRandomString() + originalFileExtension;
					Date date = new Date();
				
					file = new File(filePath + storedFileName);
					multpartFile.transferTo(file);
					listMap = new HashMap<String, Object>();
					listMap.put("NOTI_NO", noti_no);
					listMap.put("ORG_FILE_NAME", originalFileName);
					listMap.put("STORED_FILE_NAME", storedFileName);
					listMap.put("FILE_SIZE", multpartFile.getSize());
					listMap.put("FILE_DATE", date);
					list.add(listMap);
				}
			}
			return list;
		}
	
public List<Map<String, Object>> parseInsertCmtFileInfo(CommentModel commentModel, MultipartHttpServletRequest mpRequest) throws Exception{
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multpartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> listMap = null;
		
		int bcomment_no = commentModel.getBcomment_no();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		} 
		
		while (iterator.hasNext()) {
			multpartFile = mpRequest.getFile(iterator.next());
			
			if(multpartFile.isEmpty() == false) {
				originalFileName = multpartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				
				storedFileName = getRandomString() + originalFileExtension;
				Date date = new Date();
				
				file = new File(filePath + storedFileName);
				multpartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("BCOMMENT_NO", bcomment_no);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multpartFile.getSize());
				listMap.put("FILE_DATE", date);
				list.add(listMap);
			}
		}
		return list;
	}
	
	
	public List<Map<String, Object>> parseUpdateFileInfo(BoardModel boardModel, String[] files,String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
		
		Iterator<String> iterator = mpRequest.getFileNames();
		MultipartFile multipartFile = null; 
		String originalFileName = null; 
		String originalFileExtension = null; 
		String storedFileName = null; 
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		int board_no = boardModel.getBoard_no();
		
		while(iterator.hasNext()){ 
			multipartFile = mpRequest.getFile(iterator.next()); 
			if(multipartFile.isEmpty() == false){ 
				originalFileName = multipartFile.getOriginalFilename(); 
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); 
				storedFileName = getRandomString() + originalFileExtension; 
				multipartFile.transferTo(new File(filePath + storedFileName)); 
				
				Date date = new Date();
				
				listMap = new HashMap<String,Object>();
				listMap.put("NEW_FILE", "Y");
				listMap.put("BOARD_NO", board_no);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				listMap.put("FILE_DATE", date);
				list.add(listMap);
			}
		}
		if(files != null && fileNames != null){ 
			for(int i = 0; i<fileNames.length; i++) {
					listMap = new HashMap<String,Object>();
                    listMap.put("NEW_FILE", "N");
					listMap.put("FILE_NO", files[i]); 
					list.add(listMap); 
			}
		}
		return list;
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
