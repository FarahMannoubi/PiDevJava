/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author dell
 */
public class Media {
    
    private int id;
    private int produit_id;
    private String image;
    private String video;

    public Media(int id, int produit_id, String image, String video) {
        this.id = id;
        this.produit_id = produit_id;
        this.image = image;
        this.video = video;
    }

    public Media(int produit_id, String image, String video) {
        this.produit_id = produit_id;
        this.image = image;
        this.video = video;
    }

    public Media() {
        
    }

    public Media(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVidéo(String vidéo) {
        this.video = vidéo;
    }

    @Override
    public String toString() {
        return "Media{" + "id=" + id + ", produit_id=" + produit_id + ", image=" + image + ", vid\u00e9o=" + video + '}';
    }
    
    
    
    
}
