package com.ho.managment.Service;

import com.ho.managment.controller.order.OrderConverter;
import com.ho.managment.controller.order.OrderDto;
import com.ho.managment.persistance.models.Client;
import com.ho.managment.persistance.models.Order;
import com.ho.managment.persistance.repository.ClientRepository;
import com.ho.managment.persistance.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderConverter orderConverter;

    public List<OrderDto> findAll(){
        return orderRepository
            .findAll()
            .stream()
            .map(orderConverter::convert)
            .collect(Collectors.toList());
    }

    public OrderDto save(OrderDto orderDto){
        Client client = clientRepository.findById(orderDto.getClientId()).orElseThrow(EntityExistsException::new);
        Order order = orderConverter.convert(orderDto,client);
        return orderConverter.convert(orderRepository.save(order));
    }


    public void delete(Integer id) {
        if(!orderRepository.existsById(id)) {
            throw new EntityNotFoundException("Invalid Id was provided");
        }
        orderRepository.deleteById(id);
    }

    public OrderDto update(OrderDto orderDto){
        if(orderRepository.existsById(orderDto.getId()) ) {
            Client client = clientRepository
                .findById(orderDto.getClientId())
                .orElseThrow(EntityExistsException::new);

            Order order = orderConverter.convert(orderDto, client);
            return orderConverter.convert(orderRepository.save(order));
        }
        else throw new RuntimeException("cannot update inexistent order");
    }
}
