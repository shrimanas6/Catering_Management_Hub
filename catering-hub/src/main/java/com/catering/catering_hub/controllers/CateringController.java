package com.catering.catering_hub.controllers;

import com.catering.catering_hub.models.*;
import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;
import com.catering.catering_hub.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cater")
public class CateringController {

    private final CustomerInfoService customerService;
    private final UserInfoService userService;
    private final RoleInfoService roleService;
    private final ItemInfoService itemService;
    private final SessionInfoService sessionService;
    private final CateringOrdersInfoService orderService;
    private final SessionItemsInfoService sessionItemsService;

    public CateringController(CustomerInfoService customerService, UserInfoService userService, RoleInfoService roleService, ItemInfoService itemService, SessionInfoService sessionService, CateringOrdersInfoService orderService, SessionItemsInfoService sessionItemsService) {
        this.customerService = customerService;
        this.userService = userService;
        this.roleService = roleService;
        this.itemService = itemService;
        this.sessionService = sessionService;
        this.orderService = orderService;
        this.sessionItemsService = sessionItemsService;
    }

    @PostMapping("/saveRoleInfo")
    public ResponseEntity<?> saveRoleInfo(@RequestBody RoleInfoModel role){
        return new ResponseEntity<>(roleService.saveRoleInfo(role), HttpStatus.CREATED);
    }

    @PostMapping("/saveUserInfo")
    public ResponseEntity<?> saveUserInfo(@RequestBody UserInfoModel user){
        return new ResponseEntity<>(userService.saveUserInfo(user), HttpStatus.CREATED);
    }

    @PostMapping("/saveItemInfo")
    public ResponseEntity<?> saveItemInfo(@RequestBody ItemMasterModel item){
        return new ResponseEntity<>(itemService.saveItemInfo(item), HttpStatus.CREATED);
    }

    @PostMapping("/saveCustomerInfo")
    public ResponseEntity<?> saveCustomerInfo(@RequestBody CustomerInfoModel customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllCustomers")
    public ResponseEntity<?> getAllCustomers(){
        List<CustomerInfoModel> customerModelList = new ArrayList<>(customerService.getAllCustomers());
        customerModelList.forEach(System.out::println);
        return new ResponseEntity<>(customerModelList, HttpStatus.OK);
    }

    @PostMapping("/saveSessionInfo")
    public ResponseEntity<?> saveSessionInfo(@RequestBody SessionsModel sessions){
        return new ResponseEntity<>(sessionService.saveOrderSession(sessions), HttpStatus.CREATED);
    }

    @PostMapping("/saveOrderInfo")
    public ResponseEntity<?> saveOrderInfo(@RequestBody CateringOrdersModel orders){
        return new ResponseEntity<>(orderService.saveCateringOrderInfo(orders), HttpStatus.CREATED);
    }

    @PostMapping("/saveSessionItemsInfo")
    public ResponseEntity<?> saveSessionItemsInfo(@RequestBody SessionItemsModel sessionItems){
        return new ResponseEntity<>(sessionItemsService.saveSessionItemsInfo(sessionItems), HttpStatus.CREATED);
    }

    @PostMapping("/saveCateringOrdersInfo")
    public ResponseEntity<?> saveCaterOrders(@RequestBody CateringOrdersJsonModel caterOders){
        orderService.saveCateringOrderObjectInfo(caterOders);
        System.out.println("Event note and order Id's saved successfully");

        List<SessionItemsModel> sessionItemsList = sessionService
                .saveSessionsJsonList(caterOders.getSessionsJsonModel());
        System.out.println("Session Information saved successfully");

        sessionItemsService.saveSessionItemsFilteredInfo(sessionItemsList);
        System.out.println("Structured the catering order details and initiated the order placement.");

        return new ResponseEntity<>(sessionItemsService.saveOrderItemsList(), HttpStatus.CREATED);
    }
}
