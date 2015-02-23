io.coderate.accurest.dsl.GroovyDsl.make {
    request {
        method 'PUT'
        url $(client(regex('/api/marketing/[0-9]{2}')), server('/api/marketing/12'))
        headers {
            header 'Content-Type': 'application/json'
        }
        body '''\
    [{
        "person" : {
        "firstName" : "Chuck",
        "lastName" : "Norris"
    },
    "decision" : "APPROVED"
    }]
'''
    }
    response {
        status 200
    }
}