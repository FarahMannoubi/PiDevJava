/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListener;
import Models.Categorie;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class InteretCategorieController implements Initializable {

    @FXML
    private Label labcategorie;
    private void click(MouseEvent mouseEvent) {
       // myListener.onClickListener(categorie);
    }
    /**
     * Initializes the controller class.
     */
     private Categorie categorie;
    private MyListener myListener;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData(Categorie categorie, MyListener myListener) {
        this.categorie = categorie;
        this.myListener = myListener;
        labcategorie.setText(categorie.getLibelle());
        //priceLable.setText(Main.CURRENCY + fruit.getPrice());
        //Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        //img.setImage(image);
    }
}
