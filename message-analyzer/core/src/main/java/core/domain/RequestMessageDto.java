package core.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class RequestMessageDto {

    @NonNull
    private MessageType messageType;

    @NonNull
    private String messageText;

}
