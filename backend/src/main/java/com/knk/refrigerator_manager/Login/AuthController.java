package com.knk.refrigerator_manager.Login;
import com.knk.refrigerator_manager.Config.SecurityUtil;
import com.knk.refrigerator_manager.jwt.TokenDto;
import com.knk.refrigerator_manager.jwt.TokenRequestDto;
import com.knk.refrigerator_manager.refrigerator.RefrigeratorService;
import com.knk.refrigerator_manager.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final RefrigeratorService refrigeratorService;

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
    public String logingettest() {
        String userName = SecurityUtil.getCurrentMemberId();
        return userName;
    }


}