package com.design.pattern._02_structural_patterns._09_decorator._02_after;

public class App {

    private static boolean enabledSpamFilter = true;
    private static boolean enabledTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        /* true 일경우 데코레이터를 적용해서 스팸필터링 데코레이터에 타깃을 넘겨준다. */
        if (enabledSpamFilter)
            commentService = new SpamFilteringDecorator(commentService);

        if (enabledTrimming)
            commentService = new TrimmingCommentDecorator(commentService);

        Client client = new Client(commentService);
        client.writeComment("댓글 1등 입니다.");
        client.writeComment("바보 멍충이");
        client.writeComment("example@naver.com");
    }
}
