//package fin;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.HashSet;
//
//public class Handler extends  Thread {
//
//private Socket socket;
//private String name;
//private BufferedReader in;
//private PrintWriter out;
//
//	public Handler(Socket accept, String name, HashSet<String> names, HashSet<PrintWriter> writers) {
//		this.socket =socket;
//		this.name =name;
//	}
//
//	public void run(){
//		try {
//			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			out = new PrintWriter(socket.getOutputStream(),true);
//			writers.add(out);
//			while(true){
//				String input = in.readLine();
//				if(input == null){
//					return;
//				}
//				for(PrintWriter writer:writers){
//					writer.println(name + ": " + input);
//					
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(name!=null){
//				names.remove(name);
//			}
//			if(out!=null){
//				writers.remove(out);
//			}
//			try{
//				socket.close();
//			}catch(IOException e){
//				
//			}
//		}
//	}
//
//}
