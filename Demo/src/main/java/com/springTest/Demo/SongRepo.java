package com.springTest.Demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// import org.springframework.stereotype.Repository;
@Repository
public interface SongRepo  extends JpaRepository<Song,Long> {

}
