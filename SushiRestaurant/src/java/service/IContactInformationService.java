/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Local;

/**
 *
 * @author Camer
 */
@Local
public interface IContactInformationService {
    String getJumbotronName();
}