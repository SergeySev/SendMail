package com.example.sendMail.registration.tocken;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

    public ConfirmationToken getConfirmationToken(Long id) {
        return confirmationTokenRepository.findByAppUser_Id(id).orElseThrow(() -> new IllegalStateException("not found token"));
    }

    public void deleteConfirmationToken(Long tokenId) {
        confirmationTokenRepository.deleteById(tokenId);
    }
}
