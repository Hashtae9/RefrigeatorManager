package com.knk.refrigerator_manager.Login;
import com.knk.refrigerator_manager.Config.SecurityUtil;
import com.knk.refrigerator_manager.jwt.TokenDto;
import com.knk.refrigerator_manager.jwt.TokenRequestDto;
import com.knk.refrigerator_manager.user.User;
import com.knk.refrigerator_manager.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(authService.login(userRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
    @GetMapping("/logingettest")
    public String logingettest(Authentication authentication) {
        String userName = SecurityUtil.getCurrentMemberId();
        return userName;
    }
}