/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Clase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface ClaseFacadeLocal {

    void create(Clase clase);

    void edit(Clase clase);

    void remove(Clase clase);

    Clase find(Object id);
    
    Clase findNum (int num);

    List<Clase> findAll();

    List<Clase> findRange(int[] range);

    int count();
    
}
