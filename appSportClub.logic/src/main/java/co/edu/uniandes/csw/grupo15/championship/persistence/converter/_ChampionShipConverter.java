/* ========================================================================
 * Copyright 2014 grupo15
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 grupo15

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.grupo15.championship.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.grupo15.championship.logic.dto.ChampionShipDTO;
import co.edu.uniandes.csw.grupo15.championship.persistence.entity.ChampionShipEntity;

public abstract class _ChampionShipConverter {

 
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static ChampionShipDTO entity2PersistenceDTO(ChampionShipEntity entity){
		if (entity != null) {
			ChampionShipDTO dto = new ChampionShipDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
 
			    if(entity.getStartDate() != null){
					dto.setStartDate(DATE_FORMAT.format(entity.getStartDate()));
				}	
 
			    if(entity.getEndDate() != null){
					dto.setEndDate(DATE_FORMAT.format(entity.getEndDate()));
				}	
			return dto;
		}else{
			return null;
		}
	}
	
	public static ChampionShipEntity persistenceDTO2Entity(ChampionShipDTO dto){
		if(dto!=null){
			ChampionShipEntity entity=new ChampionShipEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
 
			      try{ 
			        if(dto.getStartDate() != null){
						entity.setStartDate(DATE_FORMAT.parse(dto.getStartDate()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_ChampionShipConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
 
			      try{ 
			        if(dto.getEndDate() != null){
						entity.setEndDate(DATE_FORMAT.parse(dto.getEndDate()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_ChampionShipConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<ChampionShipDTO> entity2PersistenceDTOList(List<ChampionShipEntity> entities){
		List<ChampionShipDTO> dtos=new ArrayList<ChampionShipDTO>();
		for(ChampionShipEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<ChampionShipEntity> persistenceDTO2EntityList(List<ChampionShipDTO> dtos){
		List<ChampionShipEntity> entities=new ArrayList<ChampionShipEntity>();
		for(ChampionShipDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}