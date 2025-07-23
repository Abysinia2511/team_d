package com.deeptrain.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deeptrain.dto.LearnerKpiDto;
import com.deeptrain.model.Session;
import com.deeptrain.model.UserResponse;
import com.deeptrain.repository.SessionRepository;
import com.deeptrain.repository.UserResponseRepository;

@Service
public class KpiService {

    private final SessionRepository sessionRepo;
    private final UserResponseRepository responseRepo;

    public KpiService(SessionRepository sessionRepo, UserResponseRepository responseRepo) {
        this.sessionRepo = sessionRepo;
        this.responseRepo = responseRepo;
    }

    public LearnerKpiDto computeKpiForUser(Long userId) {
        List<Session> sessions = sessionRepo.findByUserId(userId);
        List<UserResponse> responses = responseRepo.findByUserId(userId);

        double avgDuration = sessions.stream()
            .mapToLong(s -> Duration.between(s.getStartTime(), s.getEndTime()).toMillis())
            .average().orElse(0.0);

        long totalResponses = responses.size();
        long correctResponses = responses.stream().filter(UserResponse::isCorrect).count();

        double quizAccuracy = totalResponses > 0
                ? ((double) correctResponses / totalResponses) * 100
                : 0.0;

        LearnerKpiDto dto = new LearnerKpiDto();
        dto.setUserId(userId);
        dto.setTotalSessions(sessions.size());
        dto.setAverageSessionDuration(avgDuration / 1000); // seconds
        dto.setQuizAccuracy(quizAccuracy);
        dto.setDecisionCorrectness(quizAccuracy); // use same for now

        return dto;
    }

   
}
