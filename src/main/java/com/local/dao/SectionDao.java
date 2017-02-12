/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao;

import com.local.model.Section;
import java.util.List;

/**
 *
 * @author Roudhentel
 */
public interface SectionDao {

	void save(Section section);
        
        void update(Section section);
        
	List<Section> findByCourseYearId(int id);
}
