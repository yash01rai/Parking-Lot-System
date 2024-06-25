package respositories;

import models.Token;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TokenRepositary {

    private Map<Long, Token> tokens = new TreeMap<>(); // mocking database

    private Long previousId = 0L;

    public Optional<Token> getTokenById(Long tokenId) {
        if(tokens.containsKey(tokenId)) {
            return Optional.of(tokens.get(tokenId));
        }

        return Optional.empty();
    }

    public Token save(Token token) {

        previousId += 1;
        token.setId(previousId);
        tokens.put(previousId, token);

        return token;
    }
}
