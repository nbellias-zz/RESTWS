/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bel.nick.restws;

/**
 *
 * @author nikolaos
 */
public class Greeting {

    private Long id;
    private String content;
    private String image;

    public Greeting() {
    }

    public Greeting(Long id, String content, String image) {
        this.id = id;
        this.content = content;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Greeting{" + "id=" + id + ", content=" + content + ", image=" + image + '}';
    }

    

}
