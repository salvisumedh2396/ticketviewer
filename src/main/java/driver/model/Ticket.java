package driver.model;

public class Ticket {

    private long assigneeId = 0;
    private long[] collaboratorsIds;
    private String createdAt;
    protected CustomFields customFields;
    private String description;
    private String dueAt;
    private String externalId;
    private long[] followerIds;
    private long groupId;
    private boolean hasIncidents;
    private long id;
    private long organizationId;
    private String priority;
    private long problemId;
    private String rawSubject;
    private String recipient;
    private long requestorId;
    protected SatisfactionRating satisfactionRating;
    private long[] sharingAgreementIds;
    private String status;
    private String subject;
    private long submitterId;
    private String[] tags;
    private String type;
    private String updatedAt;
    private String url;
    protected Via via;

    public Ticket() {
    }

    public Ticket(long assigneeId, long[] collaboratorsIds, String createdAt, CustomFields customFields, String description, String dueAt, String externalId, long[] followerIds, long groupId, boolean hasIncidents, long id, long organizationId, String priority, long problemId, String rawSubject, String recipient, long requestorId, SatisfactionRating satisfactionRating, long[] sharingAgreementIds, String status, String subject, long submitterId, String[] tags, String type, String updatedAt, String url, Via via) {
        this.assigneeId = assigneeId;
        this.collaboratorsIds = collaboratorsIds;
        this.createdAt = createdAt;
        this.customFields = customFields;
        this.description = description;
        this.dueAt = dueAt;
        this.externalId = externalId;
        this.followerIds = followerIds;
        this.groupId = groupId;
        this.hasIncidents = hasIncidents;
        this.id = id;
        this.organizationId = organizationId;
        this.priority = priority;
        this.problemId = problemId;
        this.rawSubject = rawSubject;
        this.recipient = recipient;
        this.requestorId = requestorId;
        this.satisfactionRating = satisfactionRating;
        this.sharingAgreementIds = sharingAgreementIds;
        this.status = status;
        this.subject = subject;
        this.submitterId = submitterId;
        this.tags = tags;
        this.type = type;
        this.updatedAt = updatedAt;
        this.url = url;
        this.via = via;
    }

    public long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public long[] getCollaboratorsIds() {
        return collaboratorsIds;
    }

    public void setCollaboratorsIds(long[] collaboratorsIds) {
        this.collaboratorsIds = collaboratorsIds;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public CustomFields getCustomFields() {
        return customFields;
    }

    public void setCustomFields(CustomFields customFields) {
        this.customFields = customFields;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public long[] getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(long[] followerIds) {
        this.followerIds = followerIds;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public boolean isHasIncidents() {
        return hasIncidents;
    }

    public void setHasIncidents(boolean hasIncidents) {
        this.hasIncidents = hasIncidents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getProblemId() {
        return problemId;
    }

    public void setProblemId(long problemId) {
        this.problemId = problemId;
    }

    public String getRawSubject() {
        return rawSubject;
    }

    public void setRawSubject(String rawSubject) {
        this.rawSubject = rawSubject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public long getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(long requestorId) {
        this.requestorId = requestorId;
    }

    public SatisfactionRating getSatisfactionRating() {
        return satisfactionRating;
    }

    public void setSatisfactionRating(SatisfactionRating satisfactionRating) {
        this.satisfactionRating = satisfactionRating;
    }

    public long[] getSharingAgreementIds() {
        return sharingAgreementIds;
    }

    public void setSharingAgreementIds(long[] sharingAgreementIds) {
        this.sharingAgreementIds = sharingAgreementIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(long submitterId) {
        this.submitterId = submitterId;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }
}
