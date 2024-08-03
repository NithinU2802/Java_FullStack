package com.example.Web.service;

import com.example.Web.dto.ClubDto;
import com.example.Web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();
    Club saveClub(Club club);
}
