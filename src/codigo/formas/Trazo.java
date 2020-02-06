/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.formas;

import java.awt.BasicStroke;

/**
 *
 * @author igorr
 */
public class Trazo extends BasicStroke {
    //defino dos constructores para clase basic strokes
    public Trazo(int grosor){
    super(grosor);
}
    public Trazo (int _grosor, boolean rayas){
        super(_grosor, BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL,20.0f,  new float[]{10.0f,10.0f},0.0f);
    }
    
}
