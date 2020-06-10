package javafx;
import java.util.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.*;
 
public class Calender extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public String findday(int day,int month,int year)
    {int m=year/100;
    	if (m%4==0) m=2; else if(m%4==1) m=0;else if (m%4==2) m=5; else m=3;
    int temp=year%100;
    int monthnumber[]= {0,3,28,14,4,9,6,11,8,5,10,7,12};
    String date[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    if (year%400==0 || (year%4==0 && year%100!=0))
    	{monthnumber[1]=4;monthnumber[2]=29;
    	}
    temp=(temp/12+temp%12+(temp%12)/4+m+(day-monthnumber[month]+35))%7;
    return date[temp];
    
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("The Calender of Zarzees");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label day = new Label("DAY:");
        grid.add(day, 0, 0);

        TextField daytext = new TextField();
        daytext.setId("daytext");
        grid.add(daytext, 1, 0);
      

        Label pw = new Label("MONTH:");
        grid.add(pw, 0, 1);

        TextField monthtext = new TextField();
        monthtext.setId("monthtext");
        grid.add(monthtext, 1, 1);
     
        Label year=new Label("YEAR:");
        grid.add(year,0,2);
        TextField yeartext=new TextField();
        yeartext.setId("yeartext");
        grid.add(yeartext, 1, 2);
      
        Button btn = new Button("Go");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        grid.add(actiontarget, 1, 6);
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	try {
            	 int Day=Integer.parseInt(daytext.getText());
            	 int Year=Integer.parseInt(yeartext.getText());
            	 int Month=Integer.parseInt(monthtext.getText());
                actiontarget.setText(findday(Day,Month,Year));
            	}
            catch(Exception e1)
            	{
            	 actiontarget.setText("Invalid");
            	}
            }
        });
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(("javafx.css"));
        primaryStage.show();
    }
}