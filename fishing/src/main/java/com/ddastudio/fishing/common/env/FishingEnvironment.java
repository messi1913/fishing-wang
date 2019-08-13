package com.ddastudio.fishing.common.env;

import com.ddastudio.fishing.common.audit.Audit;
import com.ddastudio.fishing.common.audit.AuditListener;
import com.ddastudio.fishing.common.audit.Auditable;
import lombok.*;

import javax.persistence.*;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019-08-13
 */
@Data
@Builder
@Entity
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditListener.class)
public class FishingEnvironment implements Auditable {

    @Id
    private String id;
    private String property;
    private Integer appId;
    private String description;

    @Embedded
    private Audit audit;

}
