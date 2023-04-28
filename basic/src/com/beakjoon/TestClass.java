package com.beakjoon;


import java.util.*;

public class TestClass {
    /** new String[]{"development", "marketing", "hometask"} */
    /** new String[]{"recruitment", "education", "officetask"}, */
    /**
     * 와 같은기준점은 Class나 Enum으로 추출하는것이 좋음
     */
    public static void main(String[] args) {
        solution(3, new String[]{"development", "marketing", "hometask"},
                new String[]{"recruitment", "education", "officetask"}, new String[]{
                        "1 development hometask", "1 recruitment marketing", "2 hometask",
                        "2 development marketing", "3 marketing", "3 officetask", "3 development"
                });
    }

    /** snake_case에서 camel case로 문법 변경하는것이 좋음 */
    private static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks,
                                  String[] employees) {
        int[] answer = {};
        ArrayList<Integer> answers = new ArrayList<>();
        // 재택자
        HashMap<Integer, String> remote_employee = new LinkedHashMap<>();
        // 출근자
        HashMap<Integer, String> office_employee = new HashMap<>();

        HashSet task = new HashSet();

        // 재택업무를 set에 add
        setWorkHome(remote_tasks, task);

        for (int i = 0; i < employees.length; i++) {
            StringTokenizer st = new StringTokenizer(employees[i], " ");
            boolean flag = false;
            // 팀번호
            int team_num = Integer.parseInt(st.nextToken());
            // 사원번호
            String employee_num = Integer.toString(i + 1);

            // 출근업무가 있는지 check
            flag = isRemoteHomeWork(office_employee, task, st, flag, team_num, employee_num);

            setRemoteEmployeeMap(remote_employee, flag, team_num, employee_num);
        }

        // 정답 insert
        for (Integer i : remote_employee.keySet()) {
            if (office_employee.containsKey(i)) {
                // 출근자가 있는 팀이면
                for (int x = 0; x < remote_employee.get(i).split(" ").length; x++) {
                    answers.add(Integer.valueOf(remote_employee.get(i).split(" ")[x]));
                }
            } else {
                // 없는 팀이면 사원번호 먼저인 사람
                answers.add(Integer.valueOf(remote_employee.get(i).split(" ")[0]));
            }
        }

        answer = answers.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    private static void setRemoteEmployeeMap(HashMap<Integer, String> remote_employee, boolean flag, int team_num, String employee_num) {
        if (!flag) {
            if (remote_employee.containsKey(team_num)) {
                remote_employee.put(team_num,
                        remote_employee.get(team_num) + " " + employee_num);
            } else {
                remote_employee.put(team_num, employee_num);
            }
        }
    }

    private static boolean isRemoteHomeWork(HashMap<Integer, String> office_employee, HashSet task, StringTokenizer st, boolean flag, int team_num, String employee_num) {
        while (st.hasMoreTokens()) {
            if (!task.contains(st.nextToken())) {
                flag = true;
                if (office_employee.containsKey(team_num)) {
                    office_employee.put(team_num,
                            office_employee.get(team_num) + " " + employee_num);
                } else {
                    office_employee.put(team_num, employee_num);
                }
            }
        }
        return flag;
    }

    private static void setWorkHome(String[] remote_tasks, HashSet task) {
        for (int i = 0; i < remote_tasks.length; i++) {
            task.add(remote_tasks[i]);
        }
    }
}
