/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class Model implements IModel 
{
    public List<String> SetDataInfo()
    {
        List<String> users = new ArrayList();
        users.add("Enter valid  UserName:");
        users.add("Enter valid  Password:");
        return users;
    }


}
