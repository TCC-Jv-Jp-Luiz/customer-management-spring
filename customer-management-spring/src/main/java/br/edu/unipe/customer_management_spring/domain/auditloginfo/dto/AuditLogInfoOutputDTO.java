package br.edu.unipe.customer_management_spring.domain.auditloginfo.dto;

import br.edu.unipe.customer_management_spring.domain.auditloginfo.AuditLogInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@Data
public class AuditLogInfoOutputDTO {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AuditLogInfoOutputDTO(AuditLogInfo auditLogInfo) {
        this.createdAt = auditLogInfo.getCreatedAt();
        this.updatedAt = auditLogInfo.getUpdatedAt();
    }
}
