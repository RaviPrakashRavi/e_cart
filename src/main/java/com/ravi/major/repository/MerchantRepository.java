package com.ravi.major.repository;

import com.ravi.major.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Integer> {

    public Merchant findMerchantByUserId(int userId);
}
