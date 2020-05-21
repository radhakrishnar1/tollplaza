package com.example.userdomain;

import lombok.Data;

@Data
public class UnlockAccountDomain {
private String email;
private String tempPwd;
private String newPwd;
private String newConfirmPwd;
}
