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

package co.edu.uniandes.csw.grupo15.member.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.grupo15.member.logic.dto.MemberDTO;
import co.edu.uniandes.csw.grupo15.member.logic.api.IMemberLogicService;
import co.edu.uniandes.csw.grupo15.member.master.logic.api._IMemberMasterLogicService;
import co.edu.uniandes.csw.grupo15.member.master.logic.dto.MemberMasterDTO;
import co.edu.uniandes.csw.grupo15.address.logic.api.IAddressLogicService;
import co.edu.uniandes.csw.grupo15.member.logic.api.IMemberLogicService;
import co.edu.uniandes.csw.grupo15.sport.logic.api.ISportLogicService;
import co.edu.uniandes.csw.grupo15.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.grupo15.member.logic.dto.MemberDTO;
import co.edu.uniandes.csw.grupo15.sport.logic.dto.SportDTO;
import javax.inject.Inject;


public abstract class _MemberMasterMockLogicService implements _IMemberMasterLogicService {

    protected static ArrayList<MemberMasterDTO> memberMasterDtosList = new ArrayList<MemberMasterDTO>() ;
    @Inject
    protected IAddressLogicService addressPersistance;
    @Inject
    protected ISportLogicService sportPersistance;
    @Inject
    protected IMemberLogicService memberPersistance;

    public MemberMasterDTO createMasterMember(MemberMasterDTO member) {

        memberPersistance.createMember(member.getMemberEntity());
        for (AddressDTO dto : member.getCreateaddresses()) {
            addressPersistance.createAddress(dto);
        }
        for (MemberDTO dto : member.getCreaterelatives()) {
            memberPersistance.createMember(dto);
        }
        for (SportDTO dto : member.getCreatesports()) {
            sportPersistance.createSport(dto);
        }
        memberMasterDtosList.add(member);
        return member;
    }

    public MemberMasterDTO getMasterMember(Long id) {
        for (MemberMasterDTO memberMasterDTO : memberMasterDtosList) {
            if (memberMasterDTO.getMemberEntity().getId() == id) {
                return memberMasterDTO;
            }
        }

        return null;
    }

    public void deleteMasterMember(Long id) {
        for (MemberMasterDTO memberMasterDTO : memberMasterDtosList) {
            if (memberMasterDTO.getMemberEntity().getId() == id) {

                for (AddressDTO dto : memberMasterDTO.getCreateaddresses()) {
                    addressPersistance.deleteAddress(dto.getId());
                }
                memberPersistance.deleteMember(memberMasterDTO.getId());
                memberMasterDtosList.remove(memberMasterDTO);
                for (MemberDTO dto : memberMasterDTO.getCreaterelatives()) {
                    memberPersistance.deleteMember(dto.getId());
                }
                memberPersistance.deleteMember(memberMasterDTO.getId());
                memberMasterDtosList.remove(memberMasterDTO);
                for (SportDTO dto : memberMasterDTO.getCreatesports()) {
                    sportPersistance.deleteSport(dto.getId());
                }
                memberPersistance.deleteMember(memberMasterDTO.getId());
                memberMasterDtosList.remove(memberMasterDTO);
            }
        }

    }

    public void updateMasterMember(MemberMasterDTO member) {

        // update Address
        if (member.getUpdateaddresses() != null) {
            for (AddressDTO dto : member.getUpdateaddresses()) {
                addressPersistance.updateAddress(dto);
            }
        }
        // persist new Address
        if (member.getCreateaddresses() != null) {
            for (AddressDTO dto : member.getCreateaddresses()) {
                AddressDTO persistedAddressDTO = addressPersistance.createAddress(dto);
                dto = persistedAddressDTO;
            }
        }
        // delete Address
        if (member.getDeleteaddresses() != null) {
            for (AddressDTO dto : member.getDeleteaddresses()) {

                addressPersistance.deleteAddress(dto.getId());
            }
        }
        // update Member
        if (member.getUpdaterelatives() != null) {
            for (MemberDTO dto : member.getUpdaterelatives()) {
                memberPersistance.updateMember(dto);
            }
        }
        // persist new Member
        if (member.getCreaterelatives() != null) {
            for (MemberDTO dto : member.getCreaterelatives()) {
                MemberDTO persistedMemberDTO = memberPersistance.createMember(dto);
                dto = persistedMemberDTO;
            }
        }
        // delete Member
        if (member.getDeleterelatives() != null) {
            for (MemberDTO dto : member.getDeleterelatives()) {

                memberPersistance.deleteMember(dto.getId());
            }
        }
        // update Sport
        if (member.getUpdatesports() != null) {
            for (SportDTO dto : member.getUpdatesports()) {
                sportPersistance.updateSport(dto);
            }
        }
        // persist new Sport
        if (member.getCreatesports() != null) {
            for (SportDTO dto : member.getCreatesports()) {
                SportDTO persistedSportDTO = sportPersistance.createSport(dto);
                dto = persistedSportDTO;
            }
        }
        // delete Sport
        if (member.getDeletesports() != null) {
            for (SportDTO dto : member.getDeletesports()) {

                sportPersistance.deleteSport(dto.getId());
            }
        }
    }
}