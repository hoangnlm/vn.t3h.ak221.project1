package asm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ngay0104 {

	public static void main(String[] args) {
		

	}

	static void readFile() throws PhanSoException{
		try {
			FileInputStream fileInputStream = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

//Git khac github (bitbucket), tool de lay data tu github: sourcetree, command line.
//Tool write file md github: mastering markdown, markdown-editor
//gitignore
//git add --all
//git commit -m "message"
//git config --global: khong nen dung neu dung nhieu nguon git hub, git server cong ty
// nen dung: get config ... (chi dung cho folder chi dinh)
// Luu y: khong up cac file trong folder bin, build.... vi rat nang ko can thiet.


//BT ve nha: 
//so sanh github va bitbucket.
//Them huong dan trong file Readme.md giai thich da lam duoc nhung gi.


class PhanSoException extends Exception{
	public PhanSoException(String errorMessage) {
		// TODO Auto-generated constructor stub
		super(errorMessage);
	}
}
