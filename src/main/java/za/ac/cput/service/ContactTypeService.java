package za.ac.cput.service;

/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 22 August 2021
*/

import za.ac.cput.entity.ContactType;
import za.ac.cput.repository.ContactTypeRepository;
import java.util.Set;

public class ContactTypeService implements IContactTypeService {

    private static ContactTypeService service = null;
    private ContactTypeRepository  repo = null;

    private ContactTypeService(){
        this.repo = ContactTypeRepository.getRepository();
    }

    public static ContactTypeService getService(){
        if(service == null){
            service =new ContactTypeService();
        }
        return service;
    }

    @Override
    public ContactType create(ContactType contactType) {
        return this.repo.create(contactType);
    }

    @Override
    public ContactType read(String s) {
        return this.repo.read(s);
    }

    @Override
    public ContactType update(ContactType contactType) {
        return this.repo.update(contactType);
    }

    @Override
    public boolean delete(String s) {
        return this.repo.delete(s);
    }

    public Set<ContactType> getSingleContactType() {
        Set<ContactType> SingleContactType =null;
        Set<ContactType> ContactTypeSet = getAll();

        for (ContactType contacttype : ContactTypeSet)
        {
            if(contacttype.toString().trim().toUpperCase().contains("A")){
                SingleContactType.add(contacttype);
            }
        }
        return SingleContactType;
    }

    @Override
    public Set<ContactType> getAll() {
        return this.repo.getAll();
    }
}