package test2015dowm.flash;

import java.io.File;  
import java.util.ArrayList;    
import java.util.List;

public class ConvertVideo {  
	
	public static final String IMG_UPLOAD_PATH = "system.file.storage.path";
	
	private String filename;
	private final static String PATH="C:\\inetpub\\wwwroot\\images";
	private String inputfile;
	private String outputfile;
	private final static String ffmpeg="\\ffmpeg\\bin\\ffmpeg"; 
  
    public void ConvertVideocore(String filename){
    	this.filename=filename;
		this.inputfile=PATH+"\\flash\\"+filename;
		
		if (!checkfile(inputfile)) {  
            System.out.println(inputfile + " is not file");  
            return;  
        }  
        if (process(inputfile)) {  
            System.out.println("ok");  
        }  
    }
    public static void main(String[] args) {  
    	String filename="I16042811170108498.mp4";
    	
    	ConvertVideo cv=new ConvertVideo();
    	cv.ConvertVideocore(filename);
    }  
  
    /**
     * 判断用哪种转换方式
     * */
    private static boolean process(String inputfile) {  
        int type = checkContentType(inputfile);  
        boolean status = false;  
        if (type == 0) {  
            System.out.println("直接将文件转为flv文件");  
            status = processFLV(inputfile);// 直接将文件转为flv文件  
        } /*else if (type == 1) {  
            String avifilepath = processAVI(inputfile);  
            if (avifilepath == null)  
                return false;// avi文件没有得到  
            status = processFLV(inputfile);// 将avi转为flv  
        } */ 
        return status;  
    }  
  
    /**
     * 检查格式
     * */
    private static int checkContentType(String inputfile) {  
        String type = inputfile.substring(inputfile.lastIndexOf(".") + 1, inputfile.length())  
                .toLowerCase();  
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）  
        if (type.equals("avi")) {  
            return 0;  
        } else if (type.equals("mpg")) {  
            return 0;  
        } else if (type.equals("wmv")) {  
            return 0;  
        } else if (type.equals("3gp")) {  
            return 0;  
        } else if (type.equals("mov")) {  
            return 0;  
        } else if (type.equals("mp4")) {  
            return 0;  
        } else if (type.equals("asf")) {  
            return 0;  
        } else if (type.equals("asx")) {  
            return 0;  
        } else if (type.equals("flv")) {  
            return 0;  
        }  
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),  
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.  
        else if (type.equals("wmv9")) {  
            return 1;  
        } else if (type.equals("rm")) {  
            return 1;  
        } else if (type.equals("rmvb")) {  
            return 1;  
        }  
        return 9;  
    }  
  
    /**
     * 检查文件是否存在
     * */
    private static boolean checkfile(String inputfile) {  
        File file = new File(inputfile);  
        if (!file.isFile()) {  
            return false;  
        }  
        return true;  
    }  
  
    /**
     *  对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等)
     *  先用工具（mencoder）转换为avi(ffmpeg能解析的)格式.
     * */  
    private static String processAVI(String inputfile) {  
        List<String> commend = new ArrayList<String>();  
        commend.add("c:\\ffmpeg\\mencoder");  
        commend.add(inputfile);  
        commend.add("-oac");  
        commend.add("lavc");  
        commend.add("-lavcopts");  
        commend.add("acodec=mp3:abitrate=64");  
        commend.add("-ovc");  
        commend.add("xvid");  
        commend.add("-xvidencopts");  
        commend.add("bitrate=600");  
        commend.add("-of");  
        commend.add("avi");  
        commend.add("-o");  
        commend.add("c:\\ffmpeg\\output\\a.avi");  
        try {  
            ProcessBuilder builder = new ProcessBuilder();  
            builder.command(commend);  
            builder.start();  
            return "c:\\ffmpeg\\output\\a.avi";  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    /**
     * 对于ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     * 转换压缩成flv流媒体格式
     * */   
    private static boolean processFLV(String inputfile) {  
  
        if (!checkfile(inputfile)) {  
            System.out.println(inputfile + " is not file");  
            return false;  
        }  
          
        // 文件命名   
        String savename = inputfile.substring(0,inputfile.lastIndexOf("."))+".flv";
        		
        List<String> commend = new ArrayList<String>();  
        commend.add(PATH+ffmpeg);  
        commend.add("-i");  
        commend.add(inputfile);  
        commend.add("-ab");  
        commend.add("56");  
        commend.add("-ar");  
        commend.add("22050");  
        commend.add("-qscale");  
        commend.add("8");  
        commend.add("-r");  
        commend.add("15");  
        commend.add("-s");  
        commend.add("320x240");  
        commend.add(PATH+"\\outputflash\\"+savename);  
  
        try {  
            /*Runtime runtime = Runtime.getRuntime();  
            Process proce = null;  
            String cmd = "";  
            String cut = PATH+ffmpeg+".exe -i "  
                    + inputfile  
                    + " -y -f image2 -ss 8 -t 0.001 -s 320x240 "  
                    + PATH+"\\outputflash\\"+savename;  
            String cutCmd = cmd + cut;  
            proce = runtime.exec(cutCmd);  */
            ProcessBuilder builder = new ProcessBuilder(commend);  
            builder.command(commend);  
            builder.start();  
  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  
}  

