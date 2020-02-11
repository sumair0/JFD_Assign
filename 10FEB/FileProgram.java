import java.io.* ;


class FileProgram{

	public static void main(String[] args) throws IOException{

		File in = new File("source.txt");

		BufferedReader br = new BufferedReader( new FileReader(in));
		

		File out = new File("target.txt");

		BufferedWriter writer = new BufferedWriter( new FileWriter(out));
		
		CopyDataThread task = new CopyDataThread(br,in,out,writer) ;

		Thread thread = new Thread(task) ;

		thread.start() ;
	}

}

class CopyDataThread implements Runnable {

	BufferedReader br ;
	File in , out ;
	BufferedWriter writer ;

	CopyDataThread(BufferedReader br , File in , File out , BufferedWriter writer){

		this.br = br ;
		this.in = in ;
		this.out = out ;
		this.writer = writer ;

	}

	@Override
	public void run(){

		try{

			// File file = new File("target.txt") ;

			this.writer = new BufferedWriter(new FileWriter(this.out)) ;

			this.br = new BufferedReader( new FileReader(this.in) );

			StringBuilder sb = new StringBuilder("") ;

			String str = "" ;

			while((str = br.readLine()) != null)
				{
				    sb.append(str + "\n");
					System.out.println(str);
					// str = br.readLine();
					// System.out.println(str);

				    // this.writer.write(this.br.readLine()) ;


				}
			br.close();
			System.out.println(this.out) ;
		}catch(IOException e) {System.out.println("Can't read from the file currently..."); }

	}

}