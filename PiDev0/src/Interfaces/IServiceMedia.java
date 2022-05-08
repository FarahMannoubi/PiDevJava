/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Avis;
import Models.Media;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IServiceMedia {
    
     //create
    public void CreateMedia(Media M);
    
    
    //select all
    public List<Media> fetchAllMedia();
    
    //update
     public void UpdateMedia(Media M);
    
     //delete
     public void DeleteMedia(Media M );
}
