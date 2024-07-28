package com.mamivo.service.impl;

import com.mamivo.entity.List;
import com.mamivo.repository.ListRepository;
import com.mamivo.service.IListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListServiceImpl implements IListService {

    private ListRepository listRepository;

    @Override
    public List createList(List list) {
        // TODO: Handle existing lists.
        return listRepository.save(list);
    }
}
