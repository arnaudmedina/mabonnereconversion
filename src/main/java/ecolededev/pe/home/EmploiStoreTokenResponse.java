package ecolededev.pe.home;

import org.codehaus.jackson.annotate.JsonProperty;

public class EmploiStoreTokenResponse
{
        @JsonProperty("scope")
        private String scope;
        
        @JsonProperty("expires_in")
        private String expiresIn;
        
        @JsonProperty("access_token")
        private String accessToken;
        
        @JsonProperty("token_type")
        private String tokenType;

        public EmploiStoreTokenResponse()
        {
        }

        public String getScope()
        {
                return scope;
        }

        public void setScope(String scope)
        {
                this.scope = scope;
        }

        public String getExpiresIn()
        {
                return expiresIn;
        }

        public void setExpiresIn(String expiresIn)
        {
                this.expiresIn = expiresIn;
        }

        public String getAccessToken()
        {
                return accessToken;
        }

        public void setAccessToken(String accessToken)
        {
                this.accessToken = accessToken;
        }

        public String getTokenType()
        {
                return tokenType;
        }

        public void setTokenType(String tokenType)
        {
                this.tokenType = tokenType;
        }

        @Override public String toString()
        {
                return "EmploiStoreTokenResponse{" + "scope='" + scope + '\'' + ", expiresIn='" + expiresIn + '\'' + ", accessToken='" + accessToken + '\'' + '}';
        }
}
