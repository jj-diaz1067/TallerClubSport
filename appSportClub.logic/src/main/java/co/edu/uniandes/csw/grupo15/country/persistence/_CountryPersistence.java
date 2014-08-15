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

package co.edu.uniandes.csw.grupo15.country.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.grupo15.country.logic.dto.CountryDTO;
import co.edu.uniandes.csw.grupo15.country.persistence.api._ICountryPersistence;
import co.edu.uniandes.csw.grupo15.country.persistence.converter.CountryConverter;
import co.edu.uniandes.csw.grupo15.country.persistence.entity.CountryEntity;

public abstract class _CountryPersistence implements _ICountryPersistence {

  	@PersistenceContext(unitName="appSportClubPU")
 
	protected EntityManager entityManager;
	
	public CountryDTO createCountry(CountryDTO country) {
		CountryEntity entity=CountryConverter.persistenceDTO2Entity(country);
		entityManager.persist(entity);
		return CountryConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<CountryDTO> getCountrys() {
		Query q = entityManager.createQuery("select u from CountryEntity u");
		return CountryConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public CountryDTO getCountry(Long id) {
		return CountryConverter.entity2PersistenceDTO(entityManager.find(CountryEntity.class, id));
	}

	public void deleteCountry(Long id) {
		CountryEntity entity=entityManager.find(CountryEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateCountry(CountryDTO detail) {
		CountryEntity entity=entityManager.merge(CountryConverter.persistenceDTO2Entity(detail));
		CountryConverter.entity2PersistenceDTO(entity);
	}

}