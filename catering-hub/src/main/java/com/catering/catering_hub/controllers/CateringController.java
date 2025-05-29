package com.catering.catering_hub.controllers;

import com.catering.catering_hub.configs.JwtUtil;
import com.catering.catering_hub.models.*;
import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;
import com.catering.catering_hub.models.order_models.UserInfoJsonModel;
import com.catering.catering_hub.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final CateringDetailsBulkFetchSevice cateringDetailsBulkFetchService;

    private JwtUtil jwtService;

    public CateringController(CustomerInfoService customerService, UserInfoService userService, RoleInfoService roleService, ItemInfoService itemService, SessionInfoService sessionService, CateringOrdersInfoService orderService, UserInfoService userInfoService, SessionItemsInfoService sessionItemsService, CateringDetailsBulkFetchSevice cateringDetailsBulkFetchService) {
        this.customerService = customerService;
        this.userService = userService;
        this.roleService = roleService;
        this.itemService = itemService;
        this.sessionService = sessionService;
        this.orderService = orderService;
        this.sessionItemsService = sessionItemsService;
        this.cateringDetailsBulkFetchService = cateringDetailsBulkFetchService;
    }

    @GetMapping("/validate-token")
    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7); // Remove "Bearer "
        String username = jwtService.extractUsername(token);
        return ResponseEntity.ok("Token is valid for user: " + username);
    }

    //   CRUD operations related to Roles
    @PostMapping("/saveRoleInfo")
    public ResponseEntity<?> saveRoleInfo(@RequestBody RoleInfoModel role){
        return new ResponseEntity<>(roleService.saveRoleInfo(role), HttpStatus.CREATED);
    }

    @GetMapping("/fetchRoles")
    public ResponseEntity<?> getAllRoles(){
        List<RoleInfoModel> rolesList = new ArrayList<>(roleService.getRoles());
        return new ResponseEntity<>(rolesList, HttpStatus.OK);
    }

    @GetMapping("/fetchRoles/{roleId}")
    public ResponseEntity<?> getRoleById(@PathVariable("roleId") Integer roleId){
        Optional<RoleInfoModel> roleInfo = roleService.getRoleById(roleId);
        return new ResponseEntity<>(roleInfo, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRoles/{roleId}")
    public ResponseEntity<?> deleteRoleById(@PathVariable("roleId") Integer roleId){
        return new ResponseEntity<>(roleService.deleteRoleById(roleId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRoles")
    public ResponseEntity<?> deleteAllRoles(){
        return new ResponseEntity<>(roleService.deleteRoles(), HttpStatus.OK);
    }

//  CRUD operations related to Users
    @PostMapping("/register/user")
    public ResponseEntity<?> saveUserInfo(@RequestBody UserInfoJsonModel user){
        return new ResponseEntity<>(userService.saveUserInfo(user), HttpStatus.CREATED);
    }

    @GetMapping("/fetchUsers")
    public ResponseEntity<?> getAllUsers(){
        List<UserInfoModel> usersList = new ArrayList<>(userService.getUsers());
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @GetMapping("/fetchUsers/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Integer userId){
        Optional<UserInfoModel> roleInfo = userService.getUserById(userId);
        return new ResponseEntity<>(roleInfo, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsers/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsers")
    public ResponseEntity<?> deleteAllUsers(){
        return new ResponseEntity<>(userService.deleteAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users/validate-login")
    public ResponseEntity<?> validateLogin(@RequestBody UserInfoJsonModel userLoginInfo){
        return new ResponseEntity<>(userService.loginValidator(userLoginInfo), HttpStatus.OK);
    }

//  CRUD operations related to Items
    @PostMapping("/saveItemInfo")
    public ResponseEntity<?> saveItemInfo(@RequestBody ItemMasterModel item){
        return new ResponseEntity<>(itemService.saveItemInfo(item), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllItems")
    public ResponseEntity<?> getAllItems(){
        List<ItemMasterModel> itemsModelList = new ArrayList<>(itemService.getAllItems());
        return new ResponseEntity<>(itemsModelList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteItems/{itemId}")
    public ResponseEntity<?> deleteItemsById(@PathVariable("itemId") Integer itemId){
        return new ResponseEntity<>(itemService.deleteItemsById(itemId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteItems")
    public ResponseEntity<?> deleteAllItems(){
        return new ResponseEntity<>(itemService.deleteAllItems(), HttpStatus.OK);
    }

//  CRUD operations related to Customers
    @PostMapping("/saveCustomerInfo")
    public ResponseEntity<?> saveCustomerInfo(@RequestBody CustomerInfoModel customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/fetchCustomer/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable("customerId") Integer customerId){
        Optional<CustomerInfoModel> customerModel = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerModel, HttpStatus.OK);
    }

    @GetMapping("/fetchAllCustomers")
    public ResponseEntity<?> getAllCustomers(){
        List<CustomerInfoModel> customerModelList = new ArrayList<>(customerService.getAllCustomers());
        customerModelList.forEach(System.out::println);
        return new ResponseEntity<>(customerModelList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomers/{customerId}")
    public ResponseEntity<?> deleteCustomersById(@PathVariable("customerId") Integer customerId){
        return new ResponseEntity<>(customerService.deleteCustomerById(customerId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomers")
    public ResponseEntity<?> deleteAllCustomers(){
        return new ResponseEntity<>(customerService.deleteAllCustomers(), HttpStatus.OK);
    }

//  CRUD operations related to Sessions and Orders
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

    @GetMapping("/fetchOrderNote/{customerId}")
    public ResponseEntity<?> getOrderNoteById(@PathVariable("customerId") Integer customerId){
        Optional<CateringOrdersModel> orderNoteModel = orderService.getOrderNoteInfoById(customerId);
        return new ResponseEntity<>(orderNoteModel, HttpStatus.OK);
    }

//  Pass data as orderId = customerMobile + customerId(find customerId by calling getAllCustomers() api data)
    @GetMapping("/fetchSessionsInfo/{orderId}")
    public ResponseEntity<?> getSessionInfoById(@PathVariable("orderId") String orderId){
        List<SessionsModel> sessionsListByCustomer = sessionService.getSessionInfoListById(orderId);
        return new ResponseEntity<>(sessionsListByCustomer, HttpStatus.OK);
    }

    @GetMapping("/fetchSessionsBulkOrder/{orderId}")
    public ResponseEntity<?> getBulkSessionsInfo(@PathVariable("orderId") String orderId){
        List<CateringOrdersJsonModel> sessionsBulkList = cateringDetailsBulkFetchService.getSessionsWithItemsFromJoin(orderId);
        return new ResponseEntity<>(sessionsBulkList, HttpStatus.OK);
    }

    @GetMapping("/fetchSessionsBulkOrder")
    public ResponseEntity<?> getAllOrdersInfo(){
        List<CateringOrdersJsonModel> sessionsBulkList = cateringDetailsBulkFetchService.getAllOrdersInfo();
        return new ResponseEntity<>(sessionsBulkList, HttpStatus.OK);
    }

    @PostMapping("/saveCateringOrdersInfo")
    public ResponseEntity<?> saveCaterOrders(@RequestBody CateringOrdersJsonModel caterOders){
        orderService.saveCateringOrderObjectInfo(caterOders);
        System.out.println("Event note and order Id's saved/updated successfully");

        List<SessionItemsModel> sessionItemsList = sessionService
                .saveSessionsJsonList(caterOders.getSessionsJsonModel());

        sessionItemsService.saveSessionItemsFilteredInfo(sessionItemsList);
        System.out.println("Structured the catering order details and initiated the order placement.");

        return new ResponseEntity<>(sessionItemsService.saveOrderItemsList(), HttpStatus.CREATED);
    }
}
