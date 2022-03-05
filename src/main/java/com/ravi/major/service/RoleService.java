package com.ravi.major.service;
import com.ravi.major.model.Role;
import com.ravi.major.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.save(role);
    }
    public void deleteRoleById(int roleId){
        roleRepository.deleteById(roleId);
    }

}
