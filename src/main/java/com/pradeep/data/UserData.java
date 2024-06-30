package com.pradeep.data;

import com.pradeep.constants.FrameworkConstants;
import com.pradeep.utils.ExcelUtils;

import java.util.List;
import java.util.Map;

public class UserData {
    private static UserData instance;
    private String userAccount;
    private String password;
    private String itemName;
    private String country;
    private String city;
    private String address;
    private String zipCode;
    private String mob;

    private UserData() {
    }

    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
            instance.loadData();
        }
        return instance;
    }

    private void loadData() {

        List<Map<Object, Object>> list = ExcelUtils.readExcel(FrameworkConstants.getExcelDataPath(),FrameworkConstants.getExcelSheetName() );
        this.userAccount = (String) list.get(0).get("userAccount");
        this.password = (String) list.get(0).get("password");
        this.itemName = (String) list.get(0).get("item-name");
        this.country = (String) list.get(0).get("country");
        this.city = (String) list.get(0).get("city");
        this.address = (String) list.get(0).get("address");
        this.zipCode = (String) list.get(0).get("zipCode");
        this.mob = (String) list.get(0).get("mob");
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getPassword() {
        return password;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getMobNumber() {
        return mob;
    }
}
