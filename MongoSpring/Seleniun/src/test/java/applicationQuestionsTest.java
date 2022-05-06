import application.applicationQuestions;

import java.io.IOException;

public class applicationQuestionsTest extends Thread{

    applicationQuestions aq1,aq2;

   @Override
    public void start(){
       try {
           aq1=new applicationQuestions("Chrome");
       } catch (IOException e) {
           e.printStackTrace();
       }
       try {
           aq2=new applicationQuestions("Firefox");
       } catch (IOException e) {
           e.printStackTrace();
       }
       aq1.clickRegister();
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       aq2.clickRegister();
          aq1.newAccountRegister();
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       aq2.newAccountRegister();
        }

}

