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

package co.edu.uniandes.csw.grupo15.country.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.grupo15.country.logic.dto.CountryDTO;
import co.edu.uniandes.csw.grupo15.country.logic.api._ICountryLogicService;
import co.edu.uniandes.csw.grupo15.country.persistence.api.ICountryPersistence;

public abstract class _CountryLogicService implements _ICountryLogicService {

	@Inject
	protected ICountryPersistence persistance;

	public CountryDTO createCountry(CountryDTO country){
		return persistance.createCountry( country); 
    }

	public List<CountryDTO> getCountrys(){
		return persistance.getCountrys(); 
	}

	public CountryDTO getCountry(Long id){
		return persistance.getCountry(id); 
	}

	public void deleteCountry(Long id){
	    persistance.deleteCountry(id); 
	}

	public void updateCountry(CountryDTO country){
	    persistance.updateCountry(country); 
	}	
}