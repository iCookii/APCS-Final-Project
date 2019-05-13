import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TroopControl extends GameMenuDemo
{
	private Button troop;
	private Pane root;
	private Button one;
	private Button zero;
	private Stage window;
	private Label label1;
	private static ArrayList<ImageView> closestFriend = new ArrayList<ImageView>();
	private static int logic;
	public TroopControl()
	{
		root = null;
		window = null;
	}
	
	public void setRoot(Pane root)
	{
		this.root = root;
	}
	
	public void setWindow(Stage window)
	{
		this.window = window;
	}
	
	
	
	public void setMenu() throws FileNotFoundException
	{
		troop.setTranslateX(window.getWidth() * .86979167);
		troop.setTranslateY(window.getHeight() * .07692308);
		root.getChildren().add(troop);
		FileInputStream inputstream2 = new FileInputStream("res/imgs/one.png"); 
		Image imageOne = new Image(inputstream2, window.getHeight() * .065, window.getHeight() * .065, false, false); 
		one = new Button();
		one.setGraphic(new ImageView(imageOne));
		one.setTranslateX(window.getWidth() * .66145833);
		one.setTranslateY(window.getHeight() * .07692308);
		FileInputStream inputstream3 = new FileInputStream("res/imgs/zero.png"); 
		Image imageZero = new Image(inputstream3, window.getHeight() * .065, window.getHeight() * .065, false, false);
		zero = new Button();
		zero.setGraphic(new ImageView(imageZero));
		zero.setTranslateX(window.getWidth() * .71145833);
		zero.setTranslateY(window.getHeight() * .07692308);
		label1 = new Label("Troop");
		label1.setFont(Font.font("Verdana", FontWeight.BOLD, window.getHeight() * .04));
		label1.setTranslateX(window.getWidth() * .7578125);
		label1.setTranslateY(window.getHeight() * .02425);
		root.getChildren().addAll(one, zero, label1);
		listenOne();
		listenZero();
	}
	
	public void setTroop(Button troop)
	{
		this.troop = troop;
	}
	
	public void removeTroops()
	{
		root.getChildren().removeAll(one, troop, label1);
	}
	
	public void listenOne()
	{
		one.setOnMouseClicked(e -> {
			One o = new One(window, true);
			try
			{
				ImageView img = createTroop(o, true);
				root.getChildren().add(img);
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void listenZero()
	{
		zero.setOnMouseClicked(e -> {
			Zero o = new Zero(window, true);
			try
			{
				ImageView img = createTroop(o, true);
				root.getChildren().add(img);
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	
	public ImageView createTroop(Attacker a, boolean friendly) throws Exception
	{
		ImageView img = new ImageView();
		
		if(friendly)
		{
			if(a instanceof One)
			{
				Image m = new Image(new FileInputStream("res/imgs/one.png"), window.getHeight() * .165, window.getHeight() * .165, false, false);
				img = new ImageView(m);
				img.setTranslateX(window.getWidth() * .11333);
				img.setTranslateY(window.getHeight() * .77769231);
				a.setImg(img);
			}
			if(a instanceof Zero)
			{
				Image m = new Image(new FileInputStream("res/imgs/zero.png"), window.getHeight() * .165, window.getHeight() * .165, false, false);
				img = new ImageView(m);
				img.setTranslateX(window.getWidth() * .11333);
				img.setTranslateY(window.getHeight() * .77769231);
				a.setImg(img);
			}
		}
		
		
		return img;
	}
	
	
	public void reset()
	{
		One o = new One(true);
		logic = 0;
		closestFriend = new ArrayList<ImageView>();
	}
	
	public void incrementLogic()
	{
		logic++;
	}
	
	public int getLogic()
	{
		return logic;
	}
	
	public void incrementFriendly(ImageView i)
	{
		closestFriend.add(i);
	}
	
	public ArrayList<ImageView> getFriendly()
	{
		return closestFriend;
	}
	

			
}