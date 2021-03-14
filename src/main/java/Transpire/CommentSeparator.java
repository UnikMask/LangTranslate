package Transpire;

import com.github.rwitzel.streamflyer.regex.MatchProcessorResult;
import com.github.rwitzel.streamflyer.regex.MatchProcessor;


import java.util.regex.MatchResult;

public class CommentSeparator implements MatchProcessor {
    @Override
    public MatchProcessorResult process(StringBuilder characterBuffer, int firstModifiableCharacterInBuffer, MatchResult matchResult) {
        System.out.println(characterBuffer.substring(matchResult.start(), matchResult.end() + 1));
        characterBuffer.delete(matchResult.start(), matchResult.end());

        return new MatchProcessorResult(matchResult.end() - 5, true);
    }
}
