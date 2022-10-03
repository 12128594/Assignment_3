/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.Model.IModel;
import Views.ILogin;
import java.util.List;

/**
 *
 * @author 
 */
public class LoginPresenter {
        ILogin _presenterView;
        IModel _presenterModel;
        public LoginPresenter(ILogin PView, IModel PModel)
        {
            _presenterView = PView;
            _presenterModel = PModel;
        }

        public void BindViewModal()
        {
            List<String> lsdata = _presenterModel.SetDataInfo();
            _presenterView.setUsername(lsdata.get(0));
            _presenterView.setPassword(lsdata.get(1));
        }

}
