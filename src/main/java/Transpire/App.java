/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Transpire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import net.sourceforge.argparse4j.inf.Namespace;

public class App {
    public String getGreeting() {
        return "Suck ma balls";
    }



	// App arguments - stored here for now
	static Prompt promptInstance = new Prompt();
	List<String> sourceFiles;
	String sourceLanguage;
	String targetLanguage;
	String progLanguage;
	boolean appFlag = true;
	Boolean updateFlag;


	// Get files to translate in the program.
	public List<String> getFilesToTranslate(Namespace resn) {
		List<String> resFiles = (List<String>) resn.get("files");
		return resFiles;
	}


	// Get source language to translate from.
	public String getSourceLanguage(Namespace resn) {
			String resFiles = (String) resn.get("source language");
			return resFiles;
	}


	// Get target language to translate to.
	public String getTargetLanguage(Namespace resn) {
		String resFiles = (String) resn.get("target language");
		return resFiles;
	}


	// Get programming language to work on.
	public String getProgLang(Namespace resn) {
		return (String) resn.get("programming language");
	}

	public Boolean getUpdate(Namespace resn) {
		return (Boolean) resn.get("update");
	}



	/**
	 * Get application wanted variables based on given arguments.
	 * @param args The app arguments.
	 * @return Whether the program is true or false.
	 */
	public boolean getArgsInApp(String[] args) {
		Namespace resn = promptInstance.launchPrompt(args);
		if (resn != null) {
			sourceFiles =
				this.getFilesToTranslate(resn);
			sourceLanguage =
				this.getSourceLanguage(resn);
			targetLanguage =
				this.getTargetLanguage(resn);
			progLanguage = this.getProgLang(resn);
			updateFlag = this.getUpdate(resn);
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Constructor for app.
	 * @param args The application parameters.
	 */
	public App(String[] args) {
		appFlag = getArgsInApp(args);
	}


	// Get file content from a string.
	public String getFileContent(String progFile) throws IOException {
		StringBuilder contentBuild = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(new File(progFile)))) {
			String currline;
			while ((currline = br.readLine()) != null) {
				contentBuild.append(currline).append("\n");
			}
			return contentBuild.toString();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	// Write file from a string of content
	public boolean writeFile(String output, String fileName) throws IOException {
		File outDir = new File("transpireOut");
		if (!outDir.exists()); {
			outDir.mkdir();
		}
		String newFileName = "transpireOut/" + fileName;
		try (FileWriter writer = new FileWriter(newFileName)){
			writer.write(output);
			return true;
		}
		catch(IOException e) {
			return false;
		}
	}


    public static void main(String[] args) {
        //Base: transpire Bonjour.java fr
        //Backend: transpire Bonjour.java -s fr -t en
        // --help
		try{
			Translations translations = new Translations("fr", "python");
			// translations.updateTranslations("fr","python");
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		

		// App mainInstance = new App(args);
		// if (mainInstance.appFlag) {
		// 	Parser parser;
		// 	try{
		// 		parser = new Parser(mainInstance.sourceLanguage,
		// 							mainInstance.progLanguage);

		// 		// Get String from file
		// 		for (String file: mainInstance.sourceFiles) {
		// 			System.out.println(mainInstance.getFileContent(file));

		// 			if (!mainInstance.writeFile( parser.parseString(
		// 				mainInstance.getFileContent(file)), file)) {
		// 				System.out.println("IO Exception on file write!");
		// 				break;
		// 			}
		// 		}
		// 		Translations translations = new Translations("fr", "python", "translations");
		// 		translations.updateTranslations("fr","python");
		// 	}catch(NotSupportedLanguage e){
		// 		System.out.println(e.getMessage());
		// 	}catch(IOException e) {
		// 		System.out.println("Couldn't open file.");
		// 	}
		// }
    }
}
