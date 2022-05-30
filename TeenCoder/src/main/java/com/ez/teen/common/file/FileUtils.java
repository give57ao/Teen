package com.ez.teen.common.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.model.BoardModel;

@Component("fileUtils")
public class FileUtils {
	
	private static final String filePath = "E:\\JAVA\\SpringTool";
	
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
		}  //따란
		
		while (iterator.hasNext()) {
			multpartFile = mpRequest.getFile(iterator.next());
			
			if(multpartFile.isEmpty() == false) {
				originalFileName = multpartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				
				storedFileName = getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				multpartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("BOARD_NO", board_no);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multpartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
